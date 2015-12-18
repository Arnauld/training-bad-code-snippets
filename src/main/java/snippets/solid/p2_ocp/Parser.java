package snippets.solid.p2_ocp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Copied and adapted from
 * http://blog.gauffin.org/2012/05/11/solid-principles-with-real-world-examples/
 */
public class Parser {
    public void Parse(String scriptTextToProcess) throws IOException {

        BufferedReader reader = new BufferedReader(new StringReader(scriptTextToProcess));
        StringBuilder scope = new StringBuilder();
        String line = reader.readLine();
        while (line != null)
        {
            switch (line.charAt(0))
            {
                case '$':
                    // Process the entire "line" as a variable,
                    // i.e. add it to a collection of KeyValuePair.
                    AddToVariables(line);
                    break;
                case '!':
                    // Depending of what comes after the '!' character,
                    // process the entire "scope" and/or the command in "line".
                    if (line .equals("!execute"))
                        ExecuteScope(scope);
                    else if (line.startsWith("!custom_command"))
                        RunCustomCommand(line, scope);
                    else if (line .equals( "!single_line_directive"))
                        ProcessDirective(line);

                    scope = new StringBuilder();
                    break;

                default:
                    // No processing directive, i.e. add the "line"
                    // to the current scope.
                    scope.append(line);
                    break;
            }

            line = reader.readLine();
        }
    }

    private void ProcessDirective(String line) {
    }

    private void RunCustomCommand(String line, StringBuilder scope) {

    }

    private void ExecuteScope(StringBuilder scope) {

    }

    private void AddToVariables(String var) {

    }
}
