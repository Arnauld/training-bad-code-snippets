package snippets.solid.p2_ocp;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Filters {
    public interface Filter<T> {
        boolean accepts(T value);
    }

    public static class UserFilter implements Filter<User> {
        private final String firstname;

        public UserFilter(String firstname) {
            this.firstname = firstname;
        }

        @Override
        public boolean accepts(User user) {
            return firstname.equals(user.getFirstname());
        }
    }

    public static class UserFilter2 implements Filter<User> {
        private final String firstname;
        private final String lastname;

        public UserFilter2(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        @Override
        public boolean accepts(User user) {
            return (firstname == null || firstname.equals(user.getFirstname()))
                    && (lastname == null || lastname.equals(user.getLastname()));
        }
    }

    public static class FirstNameFilter implements Filter<User> {
        private final String firstname;

        public FirstNameFilter(String firstname) {
            this.firstname = firstname;
        }

        @Override
        public boolean accepts(User user) {
            return firstname.equals(user.getFirstname());
        }
    }

    public static class LastNameFilter implements Filter<User> {
        private final String lastname;

        public LastNameFilter(String lastname) {
            this.lastname = lastname;
        }

        @Override
        public boolean accepts(User user) {
            return lastname.equals(user.getLastname());
        }
    }

    public static Filter<User> firstNameAndLastNameFilter(String firstname, String lastname) {
        Filter<User> userFilter = Filters.and(
                new FirstNameFilter(firstname),
                new LastNameFilter(lastname));
        return userFilter;
    }

    public static <T> Filter<T> and(final Filter<T> one, final Filter<T> two) {
        return new Filter<T>() {
            @Override
            public boolean accepts(T value) {
                return one.accepts(value) && two.accepts(value);
            }
        };
    }

    public static <T> Filter<T> or(final Filter<T> one, final Filter<T> two) {
        return new Filter<T>() {
            @Override
            public boolean accepts(T value) {
                return one.accepts(value) || two.accepts(value);
            }
        };
    }

    /**
     *
     */
    public static class User {
        private final String firstname;
        private final String lastname;

        public User(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }
    }
}
