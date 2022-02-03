package jp.unaguna.helestakigdommod.country

import jp.unaguna.helestakigdommod.character.AngeKatrina
import jp.unaguna.helestakigdommod.character.ChaikaBlain
import jp.unaguna.helestakigdommod.character.Dokodoko
import jp.unaguna.helestakigdommod.character.HelKing
import jp.unaguna.helestakigdommod.character.InuiToko
import jp.unaguna.helestakigdommod.character.Marshal1
import jp.unaguna.helestakigdommod.character.Valkyria
import jp.unaguna.helestakigdommod.character.Yattaze
import jp.unaguna.helestakigdommod.idea.IdeaPrincessLize
import jp.unaguna.helestakigdommod.idea.IdeaPrincessists
import jp.unaguna.helestakigdommod.oob.HelestaOob1936
import jp.unaguna.helestakigdommod.state.StateShizuoka
import jp.unaguna.helestakigdommod.variable.VarAlchemistFree
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistAirplane
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistConvoys
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistGolemHumanoid
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistInfantryWeapons
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistStudyAirplane
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistStudyConvoys
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistStudyGolemHumanoid
import jp.unaguna.helestakigdommod.variable.VarCostAlchemistStudyInfantryWeapons
import jp.unaguna.helestakigdommod.variable.VarWorkingAlchemistAirplane
import jp.unaguna.helestakigdommod.variable.VarWorkingAlchemistConvoys
import jp.unaguna.helestakigdommod.variable.VarWorkingAlchemistGolemHumanoid
import jp.unaguna.helestakigdommod.variable.VarWorkingAlchemistInfantryWeapons
import jp.unaguna.hoi4modding.struct.CountryHistory
import jp.unaguna.hoi4modding.struct.common.Hoi4Date
import jp.unaguna.hoi4modding.struct.vanilla.VIdeologies
import jp.unaguna.hoi4modding.struct.vanilla.VTechs

class HelestaHistory: CountryHistory() {
    override val country by lazy { HelestaCountry() }

    init {
        capital eq StateShizuoka
        oob eq HelestaOob1936
        addIdeas eq listOf(
            IdeaPrincessLize,
            IdeaPrincessists,
        )
        setTechnology eq {
            VTechs.InfantryWeapons eq 1
            VTechs.MotorisedInfantry eq 1
            VTechs.TechSupport eq 1
            VTechs.TechRecon eq 1
            VTechs.FuelSilos eq 1
            VTechs.BasicTrain eq 1
        }
        setPolitics(VIdeologies.Neutrality) {
            lastElection eq Hoi4Date(1933, 3, 5)
            electionFrequency eq 48
            electionsAllowed eq false
        }
        setPopularities eq {
            VIdeologies.Neutrality eq 100
        }
        setConvoys eq 5
        recruitCharacters(
            HelKing,
//            LizeHelesta,
            AngeKatrina,
            InuiToko,
            ChaikaBlain,
            Dokodoko,
            Yattaze,
            Valkyria,
            Marshal1,
        )

        setVariable(VarAlchemistFree, 0)
        setVariable(VarWorkingAlchemistGolemHumanoid, 0)
        setVariable(VarWorkingAlchemistInfantryWeapons, 0)
        setVariable(VarWorkingAlchemistAirplane, 0)
        setVariable(VarWorkingAlchemistConvoys, 0)
        setVariable(VarCostAlchemistStudyGolemHumanoid, 2)
        setVariable(VarCostAlchemistStudyInfantryWeapons, 2)
        setVariable(VarCostAlchemistStudyAirplane, 2)
        setVariable(VarCostAlchemistStudyConvoys, 2)
        setVariable(VarCostAlchemistGolemHumanoid, 1)
        setVariable(VarCostAlchemistInfantryWeapons, 1)
        setVariable(VarCostAlchemistAirplane, 1)
        setVariable(VarCostAlchemistConvoys, 1)
    }
}
