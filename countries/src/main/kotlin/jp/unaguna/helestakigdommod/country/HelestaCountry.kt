package jp.unaguna.helestakigdommod.country

import jp.unaguna.hoi4modding.struct.Color
import jp.unaguna.hoi4modding.struct.Country
import jp.unaguna.hoi4modding.struct.ModFile

@ModFile
class HelestaCountry : Country() {
    override val tag = "HEL"
    override val countryName = "Helesta"
    override val color = Color(2, 10, 222)
}
