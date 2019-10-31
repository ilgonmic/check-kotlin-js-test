import kotlin.js.Promise
import kotlin.test.Test
import kotlin.test.assertTrue

//@Ignore
class MyTest {
    @Test
    fun foo() {
        assertTrue { false }
    }

    @Test
    fun fooAsync(): Promise<String> {
        return Promise { _, _ ->
            throw IllegalStateException("asdas")
        }
    }
}