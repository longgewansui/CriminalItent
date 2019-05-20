package android.bignerdranch.crimeactivity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private LocalDateTime mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = LocalDateTime.now();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public LocalDateTime getDate() {
        return mDate;
    }

    public void setDate(LocalDateTime date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
