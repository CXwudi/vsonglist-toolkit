package mikufan.cx.vtool.app.n2vex

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.extensions.spring.SpringExtension
import mikufan.cx.vtool.core.n2vex.MainExporterWithLocalWrite
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class Nico2VocaDbSongListExporterIT(
  private val mainExporterWithLocalWrite: MainExporterWithLocalWrite,
) : ShouldSpec({
  xcontext("main exporter") {
    should("run") {
      assertDoesNotThrow {
        mainExporterWithLocalWrite.run()
      }
    }
  }
}) {
  override fun extensions() = listOf(SpringExtension)
}
