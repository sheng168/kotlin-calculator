package de.akquinet.ats.kotlin.calculator

class LintAlert {

    private var LintAlert: String = ""

    /**
     * Comments for private functions should be avoided. Prefer giving the function an expressive name.
     * Split it up in smaller, self-explaining functions if necessary.
     */
    private fun doSomething(value: Boolean) {
        if (value) {
            println("yes")
        }else {
            println("no")
        }

        try {
            println("ok")
        }catch (e: Exception) {

        }
    }
}
