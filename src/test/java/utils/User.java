package utils;

public class User {
    private String login;
    private String password;
    private String name;
    private int age;
    private String birthday;

    public static class Builder {
        private String login;
        private String password;
        private String name;
        private int age;
        private String birthday;

        public Builder(){};

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder birthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.login = builder.login;
        this.password = builder.password;
        this.name = builder.name;
        this.age = builder.age;
        this.birthday = builder.birthday;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
