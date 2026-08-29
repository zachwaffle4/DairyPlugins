package dev.frozenmilk.libs

import dev.frozenmilk.FTC
import dev.frozenmilk.easyautolibraries.EasyAutoDependency
import dev.frozenmilk.easyautolibraries.EasyAutoScope

@Suppress("unused")
class FateWeaver(ftc: FTC) : EasyAutoScope<FateWeaver>(ftc)  {
    var version = "0.4.1"

    private val dependency = dependency { name ->
        EasyAutoDependency(
            group = "gay.zharel.fateweaver",
            artifact = name,
            defaultVersion = { version }
        )
    }

    val core by dependency
    val ftc by dependency
}