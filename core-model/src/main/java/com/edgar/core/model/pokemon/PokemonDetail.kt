package com.edgar.core.model.pokemon

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class PokemonDetail (
    val abilities: List<Ability>? = null,

    @SerializedName("base_experience")
    val baseExperience: Long? = null,

    val cries: Cries? = null,
    val forms: List<Species>? = null,

    @SerializedName("game_indices")
    val gameIndices: List<GameIndex>? = null,

    val height: Long? = null,

    @SerializedName("held_items")
    val heldItems: JsonArray? = null,

    val id: Long? = null,

    @SerializedName("is_default")
    val isDefault: Boolean? = null,

    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = null,

    val moves: List<Move>? = null,
    val name: String? = null,
    val order: Long? = null,

    @SerializedName("past_abilities")
    val pastAbilities: List<PastAbility>? = null,

    @SerializedName("past_types")
    val pastTypes: JsonArray? = null,

    val species: Species? = null,
    val sprites: Sprites? = null,
    val stats: List<Stat>? = null,
    val types: List<Type>? = null,
    val weight: Long? = null
)

data class Ability (
    val ability: Species? = null,

    @SerializedName("is_hidden")
    val isHidden: Boolean? = null,

    val slot: Long? = null
)

data class Species (
    val name: String? = null,
    val url: String? = null
)

data class Cries (
    val latest: String? = null,
    val legacy: String? = null
)

data class GameIndex (
    @SerializedName("game_index")
    val gameIndex: Long? = null,

    val version: Species? = null
)

data class Move (
    val move: Species? = null,

    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>? = null
)

data class VersionGroupDetail (
    @SerializedName("level_learned_at")
    val levelLearnedAt: Long? = null,

    @SerializedName("move_learn_method")
    val moveLearnMethod: Species? = null,

    val order: Long? = null,

    @SerializedName("version_group")
    val versionGroup: Species? = null
)

data class PastAbility (
    val abilities: List<Ability>? = null,
    val generation: Species? = null
)

data class GenerationV (
    @SerializedName("black-white")
    val blackWhite: Sprites? = null
)

data class GenerationIv (
    @SerializedName("diamond-pearl")
    val diamondPearl: Sprites? = null,

    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: Sprites? = null,

    val platinum: Sprites? = null
)

data class Versions (
    @SerializedName("generation-i")
    val generationI: GenerationI? = null,

    @SerializedName("generation-ii")
    val generationIi: GenerationIi? = null,

    @SerializedName("generation-iii")
    val generationIii: GenerationIii? = null,

    @SerializedName("generation-iv")
    val generationIv: GenerationIv? = null,

    @SerializedName("generation-v")
    val generationV: GenerationV? = null,

    @SerializedName("generation-vi")
    val generationVi: Map<String, Home>? = null,

    @SerializedName("generation-vii")
    val generationVii: GenerationVii? = null,

    @SerializedName("generation-viii")
    val generationViii: GenerationViii? = null
)

data class Other (
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld? = null,

    val home: Home? = null,

    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork? = null,

    val showdown: Sprites? = null
)

data class Sprites (
    @SerializedName("back_default")
    val backDefault: String? = null,

    @SerializedName("back_female")
    val backFemale: JsonElement? = null,

    @SerializedName("back_shiny")
    val backShiny: String? = null,

    @SerializedName("back_shiny_female")
    val backShinyFemale: JsonElement? = null,

    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_female")
    val frontFemale: JsonElement? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null,

    @SerializedName("front_shiny_female")
    val frontShinyFemale: JsonElement? = null,

    val other: Other? = null,
    val versions: Versions? = null,
    val animated: Sprites? = null
)

data class GenerationI (
    @SerializedName("red-blue")
    val redBlue: RedBlue? = null,

    val yellow: RedBlue? = null
)

data class RedBlue (
    @SerializedName("back_default")
    val backDefault: String? = null,

    @SerializedName("back_gray")
    val backGray: String? = null,

    @SerializedName("back_transparent")
    val backTransparent: String? = null,

    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_gray")
    val frontGray: String? = null,

    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class GenerationIi (
    val crystal: Crystal? = null,
    val gold: Gold? = null,
    val silver: Gold? = null
)

data class Crystal (
    @SerializedName("back_default")
    val backDefault: String? = null,

    @SerializedName("back_shiny")
    val backShiny: String? = null,

    @SerializedName("back_shiny_transparent")
    val backShinyTransparent: String? = null,

    @SerializedName("back_transparent")
    val backTransparent: String? = null,

    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null,

    @SerializedName("front_shiny_transparent")
    val frontShinyTransparent: String? = null,

    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class Gold (
    @SerializedName("back_default")
    val backDefault: String? = null,

    @SerializedName("back_shiny")
    val backShiny: String? = null,

    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null,

    @SerializedName("front_transparent")
    val frontTransparent: String? = null
)

data class GenerationIii (
    val emerald: OfficialArtwork? = null,

    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: Gold? = null,

    @SerializedName("ruby-sapphire")
    val rubySapphire: Gold? = null
)

data class OfficialArtwork (
    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null
)

data class Home (
    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_female")
    val frontFemale: JsonElement? = null,

    @SerializedName("front_shiny")
    val frontShiny: String? = null,

    @SerializedName("front_shiny_female")
    val frontShinyFemale: JsonElement? = null
)

data class GenerationVii (
    val icons: DreamWorld? = null,

    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: Home? = null
)

data class DreamWorld (
    @SerializedName("front_default")
    val frontDefault: String? = null,

    @SerializedName("front_female")
    val frontFemale: JsonElement? = null
)

data class GenerationViii (
    val icons: DreamWorld? = null
)

data class Stat (
    @SerializedName("base_stat")
    val baseStat: Long? = null,

    val effort: Long? = null,
    val stat: Species? = null
)

data class Type (
    val slot: Long? = null,
    val type: Species? = null
)
