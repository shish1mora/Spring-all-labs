package ru.kafpin.lab1;

public class Student {
    private long id;
    private String name;
    private String surname;
    private int enrollmentYear;
    private String group;
    private String login;
    private String email;

    public Student() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        generateLogin();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        generateEmail(); // Генерируем почту при установке имени
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        generateEmail();
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
        generateGroup();
        generateLogin();
    }

    public String getGroup() {
        return group;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    private void generateGroup() {
        String yearSuffix = String.valueOf(enrollmentYear).substring(2);
        this.group = "ПИн-1" + yearSuffix;
    }

    private void generateLogin() {
        if (group != null && id > 0) {
            this.login = "student-" + group.toLowerCase() + "-" + id;
        }
    }

    private void generateEmail() {
        if (name != null && surname != null) {
            String transliteratedSurname = transliterate(surname);
            String transliteratedName = transliterate(name);
            this.email = transliteratedSurname.toLowerCase() + "." + transliteratedName.toLowerCase() + "@mivlgu.ru";
        }
    }

    private String transliterate(String input) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            switch (ch) {
                case 'а': result.append('a'); break;
                case 'б': result.append('b'); break;
                case 'в': result.append('v'); break;
                case 'г': result.append('g'); break;
                case 'д': result.append("d"); break;
                case 'е': result.append('e'); break;
                case 'ё': result.append("yo"); break;
                case 'ж': result.append("zh"); break;
                case 'з': result.append('z'); break;
                case 'и': result.append('i'); break;
                case 'й': result.append('y'); break;
                case 'к': result.append('k'); break;
                case 'л': result.append('l'); break;
                case 'м': result.append('m'); break;
                case 'н': result.append('n'); break;
                case 'о': result.append('o'); break;
                case 'п': result.append('p'); break;
                case 'р': result.append('r'); break;
                case 'с': result.append('s'); break;
                case 'т': result.append('t'); break;
                case 'у': result.append('u'); break;
                case 'ф': result.append('f'); break;
                case 'х': result.append("kh"); break;
                case 'ц': result.append("ts"); break;
                case 'ч': result.append("ch"); break;
                case 'ш': result.append("sh"); break;
                case 'щ': result.append("shch"); break;
                case 'А': result.append('a'); break;
                case 'Б': result.append('b'); break;
                case 'В': result.append('v'); break;
                case 'Г': result.append('g'); break;
                case 'Д': result.append("d"); break;
                case 'Е': result.append('e'); break;
                case 'Ё': result.append("yo"); break;
                case 'Ж': result.append("zh"); break;
                case 'З': result.append('z'); break;
                case 'И': result.append('i'); break;
                case 'Й': result.append('y'); break;
                case 'К': result.append('k'); break;
                case 'Л': result.append('l'); break;
                case 'М': result.append('m'); break;
                case 'Н': result.append('n'); break;
                case 'О': result.append('o'); break;
                case 'П': result.append('p'); break;
                case 'Р': result.append('r'); break;
                case 'С': result.append('s'); break;
                case 'Т': result.append('t'); break;
                case 'У': result.append('u'); break;
                case 'Ф': result.append('f'); break;
                case 'Х': result.append("kh"); break;
                case 'Ц': result.append("ts"); break;
                case 'Ч': result.append("ch"); break;
                case 'Ш': result.append("sh"); break;
                case 'Щ': result.append("shch"); break;
                case 'ъ':
                case 'ь':
                    break;
                case 'ю': result.append("yu"); break;
                case 'я': result.append("ya"); break;
                default:
                    result.append(ch);
            }
        }
        return result.toString();
    }

}
