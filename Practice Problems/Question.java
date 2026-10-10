abstract class Question {
    String question;
    String correctAnswer;

    Question(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    abstract int checkAnswer(String answer);
}

class MCQ extends Question {
    MCQ(String question, String correctAnswer) {
        super(question, correctAnswer);
    }

    int checkAnswer(String answer) {
        return answer.equals(correctAnswer) ? 5 : 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(String question, String correctAnswer) {
        super(question, correctAnswer);
    }

    int checkAnswer(String answer) {
        return answer.equals(correctAnswer) ? 5 : 0;
    }
}

class Exam {
    boolean submitted = false;
    int score = 0;

    void answer(Question q, String answer) {
        if (submitted)
            System.out.println("Cannot change answers after submission.");
        else {
            score += q.checkAnswer(answer);
            System.out.println("Answer recorded.");
        }
    }

    void submit() {
        submitted = true;
        System.out.println("Exam submitted.");
        System.out.println("Total score: " + score + "/10");
    }
}

class OnlineExam {
    public static void main(String[] args) {

        MCQ q1 = new MCQ("Capital of India?", "B");
        TrueFalse q2 = new TrueFalse("Java is OOP?", "True");

        Exam exam = new Exam();

        System.out.println("Exam started.");

        exam.answer(q1, "B");
        exam.answer(q2, "True");

        exam.submit();

        exam.answer(q1, "C");
    }
}