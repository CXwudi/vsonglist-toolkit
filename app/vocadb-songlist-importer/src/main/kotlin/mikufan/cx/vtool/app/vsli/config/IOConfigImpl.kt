package mikufan.cx.vtool.app.vsli.config

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import jakarta.validation.constraints.Positive
import mikufan.cx.vtool.core.vsli.config.IOConfig
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import java.nio.file.Path
import kotlin.io.path.isReadable
import kotlin.reflect.KClass

@ConfigurationProperties(prefix = "io")
@Validated
data class IOConfigImpl(
  @get:Positive
  override val vocaDbListId: Long?,
  @get:FileReadable
  override val inputCsv: Path,
) : IOConfig

@Constraint(validatedBy = [FileReadableValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FileReadable(
  val message: String = "The input csv file must be readable",
  val groups: Array<KClass<*>> = [],
  val payload: Array<KClass<out Payload>> = []
)


class FileReadableValidator : ConstraintValidator<FileReadable, Path> {
  override fun isValid(path: Path, context: ConstraintValidatorContext): Boolean {
    return if (path.isReadable()) {
      true
    } else {
      context.disableDefaultConstraintViolation()
      context.buildConstraintViolationWithTemplate("The file $path is not readable")
        .addConstraintViolation()
      false
    }
  }
}