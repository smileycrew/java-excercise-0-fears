public class Person {
    private final Integer age;
    private final String fear;
    private final String firstName;
    private final String middleName;
    private final String lastName;

    public String[] splitLineIntoData(String line) {
        validateData(line);

        return line.split(" ");
    }

    public Integer tryParseAge(String age) {
        Integer parsedAge = 0;

        try {
            parsedAge = Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            // OPTIONAL TO KEEP THE OUTPUT CLEAN CONSIDER COMMENTING THE EXCEPTION
            String message = String.format("Could not parse the following to an integer: %s", age);
            
            System.out.println(message);
        }

        return parsedAge;
    }

    public String extractFear(String[] data, Integer min, Integer max) {
        StringBuilder fearBuilder = new StringBuilder();

        for (Integer i = min; i < max; i++) {
            fearBuilder.append(data[i]);

            if (i < max - 1) fearBuilder.append(" ");
        }

        return fearBuilder.toString();
    }

    public Person(String line) {
        String[] data = splitLineIntoData(line);

        Integer age = tryParseAge(data[2]);
        Integer lengthOfData = data.length;

        String fear = "";
        String firstName = data[0];
        String middleName = "";
        String lastName = data[1];

        if (age > 0) {
            fear = extractFear(data, 3, lengthOfData);
        } else {
            age = tryParseAge(data[3]);
            fear = extractFear(data, 4, lengthOfData);
            middleName = data[2];
        }
        
        this.age = age;
        this.fear = fear;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    
    public String getFear() {
        return fear;
    }

    @Override
    public String toString() {
        if (this.middleName.isEmpty()) {
            return String.format("\t%s %s (%d)", this.firstName, this.lastName, this.age);
        }
        return String.format("\t%s %s %s (%d)", this.firstName, this.lastName, this.middleName, this.age, this.fear);
    }

    public void validateData(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Input line cannot be null or empty.");
        }
    }
}
