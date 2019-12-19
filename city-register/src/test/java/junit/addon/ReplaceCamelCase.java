package junit.addon;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

/**
 * @author Vitaliy Dragun
 */
public class ReplaceCamelCase extends DisplayNameGenerator.Standard {

    public ReplaceCamelCase() {
    }

    @Override
    public String generateDisplayNameForClass(final Class<?> testClass) {
        return replaceCamelCase(super.generateDisplayNameForClass(testClass));
    }

    @Override
    public String generateDisplayNameForNestedClass(final Class<?> nestedClass) {
        return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
    }

    @Override
    public String generateDisplayNameForMethod(final Class<?> testClass, final Method testMethod) {
        return replaceCamelCase(testMethod.getName() + DisplayNameGenerator.parameterTypesAsString(testMethod));
    }

    protected String replaceCamelCase(final String camelCase) {
        return separateDigits(replaceCamelCaseWithWhitespace(camelCase));
    }

    private String replaceCamelCaseWithWhitespace(final String camelCase) {
        final StringBuilder result = new StringBuilder();
        result.append(camelCase.charAt(0));

        for (int i = 1; i < camelCase.length(); i++) {
            if (Character.isUpperCase(camelCase.charAt(i))) {
                result.append(' ');
                result.append(Character.toLowerCase(camelCase.charAt(i)));
            } else {
                result.append(camelCase.charAt(i));
            }
        }
        return result.toString();
    }

    private String separateDigits(final String name) {
        return name.replaceAll("([0-9]+)", " $1");
    }
}
