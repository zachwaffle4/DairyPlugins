package dev.frozenmilk.libs

import dev.frozenmilk.FTC
import dev.frozenmilk.easyautolibraries.EasyAutoDependency
import dev.frozenmilk.easyautolibraries.EasyAutoScope

@Suppress("unused")
class Next(val ftcProject: FTC) : EasyAutoScope<Next>(ftcProject) {
    val v1 = NextV1()

    inner class NextV1 internal constructor() : EasyAutoScope<NextV1>(ftcProject) {
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

    val v2 = NextV2("0.1.0")

    inner class NextV2 internal constructor(val version: String) : EasyAutoScope<NextV2>(ftcProject) {
        private fun library(conflict: EasyAutoDependency? = null) = dependency { name ->
            EasyAutoDependency(
                group = "dev.nextftc.v2",
                artifact = name,
                defaultVersion = { version },
            ) {
                conflict?.let {
                    incompatibleWith(
                        it,
                        "NextFTC v2 is incompatible with NextFTC v1"
                    )
                }
            }
        }

        val control by library(v1.control)
        val hardware by library(v1.hardware)
        val robot by library(v1.ftc)
    }
}