package jp.unaguna.helestakigdommod.variable

import jp.unaguna.hoi4modding.struct.variable.CountryIntVariable

/**
 * 空き状態の錬金術師の数
 */
object VarAlchemistFree : CountryIntVariable<Nothing>() {
    override val varName = "alchemist_free"
}

/**
 * 歩兵ゴーレム錬金生産に割り当てられている錬金術師
 */
object VarWorkingAlchemistGolemHumanoid : CountryIntVariable<Nothing>() {
    override val varName = "working_alchemist_golem_humanoid"
}

/**
 * 歩兵装備錬金生産に割り当てられている錬金術師
 */
object VarWorkingAlchemistInfantryWeapons : CountryIntVariable<Nothing>() {
    override val varName = "working_alchemist_infantry_weapons"
}

/**
 * 航空機錬金生産に割り当てられている錬金術師
 */
object VarWorkingAlchemistAirplane : CountryIntVariable<Nothing>() {
    override val varName = "working_alchemist_airplane"
}

/**
 * 輸送船団錬金生産に割り当てられている錬金術師
 */
object VarWorkingAlchemistConvoys : CountryIntVariable<Nothing>() {
    override val varName = "working_alchemist_convoys"
}

/**
 * 歩兵ゴーレム錬金生産の研究に必要な錬金術師
 */
object VarCostAlchemistStudyGolemHumanoid : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_study_golem_humanoid"
}

/**
 * 歩兵装備錬金生産の研究に必要な錬金術師
 */
object VarCostAlchemistStudyInfantryWeapons : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_study_infantry_weapons"
}

/**
 * 航空機錬金生産の研究に必要な錬金術師
 */
object VarCostAlchemistStudyAirplane : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_study_airplane"
}

/**
 * 輸送船団錬金生産の研究に必要な錬金術師
 */
object VarCostAlchemistStudyConvoys : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_study_convoys"
}

/**
 * 歩兵ゴーレム錬金生産に必要な錬金術師
 */
object VarCostAlchemistGolemHumanoid : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_golem_humanoid"
}

/**
 * 歩兵装備錬金生産に必要な錬金術師
 */
object VarCostAlchemistInfantryWeapons : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_infantry_weapons"
}

/**
 * 航空機錬金生産に必要な錬金術師
 */
object VarCostAlchemistAirplane : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_airplane"
}

/**
 * 輸送船団錬金生産に必要な錬金術師
 */
object VarCostAlchemistConvoys : CountryIntVariable<Nothing>() {
    override val varName = "cost_alchemist_convoys"
}
