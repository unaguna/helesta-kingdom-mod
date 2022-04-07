package jp.unaguna.helestakigdommod.event

import jp.unaguna.helestakigdommod.country.HelestaCountry
import jp.unaguna.helestakigdommod.flag.FlgAngeHasBeenArrested
import jp.unaguna.helestakigdommod.flag.FlgAngeHasBeenReleased
import jp.unaguna.helestakigdommod.flag.FlgTokoHasCome
import jp.unaguna.hoi4modding.struct.AiChanceModifier
import jp.unaguna.hoi4modding.struct.ConditionCountry
import jp.unaguna.hoi4modding.struct.CountryEvent
import jp.unaguna.hoi4modding.struct.CountryEventOption
import jp.unaguna.hoi4modding.struct.EventSpace
import jp.unaguna.hoi4modding.struct.ICountry
import jp.unaguna.hoi4modding.struct.ModFile
import jp.unaguna.hoi4modding.struct.vanilla.VCountry
import jp.unaguna.hoi4modding.struct.vanilla.VEventPicture
import jp.unaguna.hoi4modding.struct.vanilla.VState
import jp.unaguna.hoi4modding.struct.vanilla.VWargoal

@ModFile
class HelestaEventSpace: EventSpace(SPACE_NAME) {
    override val eventList: List<CountryEvent> by lazy { listOf(
        PeaceNegotiatedByJpn,
        HelAcceptedPeaceNegotiationFromJpn,
        HelDeniedPeaceNegotiationFromJpn,
        TokoHasCome,
        AngeHasBeenArrested,
        AngeHasBeenReleased,
        HelHasGivenUltimatum,
        HelUltimatumWasDenied,
        HelUltimatumWasAccepted,
    ) }

    companion object {
        const val SPACE_NAME = "helesta"
    }

    /**
     * Event for Helesta that Japan wants to surrender
     */
    object PeaceNegotiatedByJpn: CountryEvent("$SPACE_NAME.1") {
        override val isTriggeredOnly = true
        override val picture = VEventPicture.JapaneseChineseSurrender
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                // (Option A) We accept their surrender.
                option {
                    effectTooltip eq {
                        everyState eq {
                            limit eq {
                                owner eq {
                                    or eq {
                                        originalTag eq VCountry.JAP
                                        isSubjectOf eq VCountry.JAP
                                    }
                                }
                                isClaimedBy eq HelestaCountry()
                                controller eq {
                                    or eq {
                                        originalTag eq VCountry.JAP
                                        isSubjectOf eq VCountry.JAP
                                        originalTag eq HelestaCountry()
                                        isSubjectOf eq HelestaCountry()
                                    }
                                }
                            }
                            country(HelestaCountry()) eq {
                                transferState eq "PREV"
                            }
                        }
                    }
                    country(VCountry.JAP) eq {
                        countryEvent(HelAcceptedPeaceNegotiationFromJpn)
                    }
                    aiChance eq {
                        factor eq 90
                    }
                },
                // (Option B) No surrender! We want total victory!
                option {
                    country(VCountry.JAP) eq {
                        countryEvent(HelDeniedPeaceNegotiationFromJpn)
                    }
                    aiChance eq {
                        // If Japan has lots of major enemies, the AI will not make a separate peace
                        factor eq 0
                        modifier eq whenJapHasWarAgainst(VCountry.USA) {
                            add eq 50
                        }
                        modifier eq whenJapHasWarAgainst(VCountry.ENG) {
                            add eq 40
                        }
                        modifier eq whenJapHasWarAgainst(VCountry.SOV) {
                            add eq 30
                        }
                        modifier eq whenJapHasWarAgainst(VCountry.FRA) {
                            add eq 20
                        }
                        modifier eq whenJapHasWarAgainst(VCountry.GER) {
                            add eq 10
                        }
                        modifier eq whenJapHasWarAgainst(VCountry.HOL) {
                            add eq 10
                        }
                        modifier eq whenJapHasWarAgainst(VCountry.ITA) {
                            add eq 10
                        }
                    }
                }
            )
    }

    /**
     * Event for Japan that Helesta has accepted
     */
    object HelAcceptedPeaceNegotiationFromJpn: CountryEvent("$SPACE_NAME.2") {
        override val isTriggeredOnly = true
        override val picture = VEventPicture.JapaneseChineseSurrender
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option {
                    everyState eq {
                        limit eq {
                            owner eq {
                                or eq {
                                    originalTag eq VCountry.JAP
                                    isSubjectOf eq VCountry.JAP
                                }
                            }
                            isClaimedBy eq HelestaCountry()
                            controller eq {
                                or eq {
                                    originalTag eq VCountry.JAP
                                    isSubjectOf eq VCountry.JAP
                                    originalTag eq HelestaCountry()
                                    isSubjectOf eq HelestaCountry()
                                }
                            }
                        }
                        country(HelestaCountry()) eq {
                            transferState eq "PREV"
                            whitePeace eq VCountry.JAP
                        }
                    }
                    hiddenEffect eq {
                        setTruce(HelestaCountry(), 730)
                    }
                },
            )
    }

    /**
     * Event for Japan that Helesta has denied
     */
    object HelDeniedPeaceNegotiationFromJpn: CountryEvent("$SPACE_NAME.3") {
        override val isTriggeredOnly = true
        override val picture = VEventPicture.JapaneseChineseSurrender
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option { },
            )
    }

    /**
     * Event that Inui Toko comes Helesta
     */
    object TokoHasCome: CountryEvent("$SPACE_NAME.4") {
        override val fireOnlyOnce = true
        // TODO: 画像の差し替え
        override val picture = VEventPicture.JapaneseChineseSurrender
        override val trigger: ConditionCountry.() -> Unit = {
            originalTag eq HelestaCountry()
            or eq {
                hasWar eq true
                anyNeighborCountry eq {
                    hasWar eq true
                }
            }
        }
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option {
                    country("ROOT") eq {
                        setCountryFlag eq FlgTokoHasCome
                    }
                },
            )
    }

    /**
     * Event that Ange Katrina has been arrested
     */
    object AngeHasBeenArrested: CountryEvent("$SPACE_NAME.5") {
        override val isTriggeredOnly = true
        override val fireOnlyOnce = true
        override val picture = VEventPicture.GenericSignTreaty1
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option {
                    country("ROOT") eq {
                        setCountryFlag eq FlgAngeHasBeenArrested
                    }
                },
            )
    }

    /**
     * Event that Ange Katrina has been released
     */
    object AngeHasBeenReleased: CountryEvent("$SPACE_NAME.6") {
        override val isTriggeredOnly = true
        override val fireOnlyOnce = true
        override val picture = VEventPicture.GenericSignTreaty2
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option {
                    country("ROOT") eq {
                        setCountryFlag eq FlgAngeHasBeenReleased
                    }
                },
            )
    }

    /**
     * Event that Helesta has given an ultimatum.
     */
    object HelHasGivenUltimatum: CountryEvent("$SPACE_NAME.7") {
        override val isTriggeredOnly = true
        override val picture = VEventPicture.GenericSignTreaty2
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option {
                    aiChance eq {
                        base eq 99
                        modifier eq {
                            hasWar eq true
                            not eq { hasWarWith eq "FROM" }
                            factor eq 0
                        }
                    }
                    effectTooltip eq {
                        country("FROM") eq {
                            createWargoal("ROOT", VWargoal.AnnexEverything)
                        }
                    }
                    country("FROM") eq {
                        countryEvent(HelUltimatumWasDenied)
                    }
                },
                option {
                    aiChance eq {
                        base eq 1
                    }
                    country("FROM") eq {
                        iff eq {
                            limit eq { country("ROOT") eq { ownsState eq VState.Papua } }
                            transferState eq VState.Papua
                        }
                        iff eq {
                            limit eq { country("ROOT") eq { ownsState eq VState.WestPapua } }
                            transferState eq VState.WestPapua
                        }
                        countryEvent(HelUltimatumWasAccepted)
                    }
                },
            )
    }

    /**
     * Event that the ultimatum from Helesta was denied.
     */
    object HelUltimatumWasDenied: CountryEvent("$SPACE_NAME.8") {
        override val isTriggeredOnly = true
        override val picture = VEventPicture.GenericSignTreaty2
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option {
                    country("ROOT") eq {
                        createWargoal("FROM", VWargoal.AnnexEverything)
                    }
                },
            )
    }

    /**
     * Event that the ultimatum from Helesta was accepted.
     */
    object HelUltimatumWasAccepted: CountryEvent("$SPACE_NAME.9") {
        override val isTriggeredOnly = true
        override val picture = VEventPicture.GenericSignTreaty2
        override val optionList: List<Pair<String?, CountryEventOption.() -> Unit>>
            get() = listOf(
                option { },
            )
    }
}

private fun whenJapHasWarAgainst(enemy: ICountry, action: AiChanceModifier.()->Unit): AiChanceModifier.()->Unit {
    return {
        action(this)
        country(enemy) eq {
            hasWarWith eq VCountry.JAP
            not eq {
                hasWarWith eq "ROOT"
            }
        }
    }
}
