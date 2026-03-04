package dev.frozenmilk.libs

import dev.frozenmilk.FTC
import dev.frozenmilk.easyautolibraries.EasyAutoDependency
import dev.frozenmilk.easyautolibraries.EasyAutoScope

@Suppress("unused")
class Next(ftc: FTC) : EasyAutoScope<Next>(ftc) {
    private fun library(version: String) = dependency { name ->
        EasyAutoDependency(
            group = "dev.nextftc",
            artifact = name,
            version = version,
        )
    }

    val ftc by library("1.0.1")
    val hardware by library("1.0.1")
    val control by library("1.0.0")
    val bindings by library("1.0.1")

    val control2 by library("0.0.2")
    private fun extension(version: String) = dependency { name ->
        EasyAutoDependency(
            group = "dev.nextftc.extensions",
            artifact = name,
            version = version,
        )
    }

    val roadrunner by extension("1.0.0")
    val pedro by extension("1.0.0")
    val fateweaver by extension("1.0.0")
}