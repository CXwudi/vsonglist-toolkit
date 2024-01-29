package mikufan.cx.vtool.core.n2vex.config

import jakarta.validation.constraints.Positive
import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.notExists

interface IOConfig {
  @get:Positive
  val nicoListId: Long
  val outputCsv: Path
  val notFoundCsv: Path

  fun createFolders() {
    if (outputCsv.parent.notExists()) {
      outputCsv.parent.createDirectories()
    }
    if (notFoundCsv.parent.notExists()) {
      notFoundCsv.parent.createDirectories()
    }
  }

}
