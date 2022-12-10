package com.example.blind_test;

public class Questions {
    private String mQuestions[] = {
            "What is the number?",
            "What is the number?",
            "What is the number?",
            "What is the number?",
            "What is the number?",
            "What is the number?",
            "What is the number?",
            "What is the number?"
    };
    private String mChoice[][]={
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"},
            {"1","2","3","4","5","6","7","8"}
    };
    private String mImages[] = {
            "img1",
            "img2",
            "img3",
            "img4",
            "img5",
            "img6",
            "img7",
            "img8"
    };

    private String mQuestionsType[] = {
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton",
            "radiobutton"
    };
    private String mCorrectAnswers[] = {
            "4",
            "5",
            "8",
            "4",
            "1",
            "3",
            "4",
            "2"
    };

    public String getQuestions(int q) {
        String question = mQuestions[q];
        return question;
    }

    public String[] getChoice(int q) {
        String [] choice = mChoice[q];
        return choice;
    }

    public String getImages(int q) {
        String img = mImages[q];
        return img;
    }

    public String getType(int q) {
        String type = mQuestionsType[q];
        return type;
    }
    public int getLength(){
        return mQuestions.length;
    }

    public String getCorrectAnswers(int q) {
        String correct = mCorrectAnswers[q];
        return correct;
    }
}
