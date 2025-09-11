package com.edgar.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.edgar.core.ui.R

val MontserratFontFamily = FontFamily(
    Font(R.font.montserrat_black, FontWeight.Black),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_extralight, FontWeight.ExtraLight),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_thin, FontWeight.Thin),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = Typography().bodyLarge.copy(fontFamily = MontserratFontFamily),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = MontserratFontFamily),
    bodySmall = Typography().bodySmall.copy(fontFamily = MontserratFontFamily),
    titleLarge = Typography().titleLarge.copy(fontFamily = MontserratFontFamily),
    titleMedium = Typography().titleMedium.copy(fontFamily = MontserratFontFamily),
    titleSmall = Typography().titleSmall.copy(fontFamily = MontserratFontFamily),
    labelLarge = Typography().labelLarge.copy(fontFamily = MontserratFontFamily),
    labelMedium = Typography().labelMedium.copy(fontFamily = MontserratFontFamily),
    labelSmall = Typography().labelSmall.copy(fontFamily = MontserratFontFamily),
)