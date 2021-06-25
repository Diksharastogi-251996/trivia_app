package newquizeapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserWithAttempts implements Parcelable {

    @Embedded
    private newquizeapp.data.User user;
    @Relation(
            parentColumn = "email",
            entityColumn = "email",
            entity = newquizeapp.data.Attempt.class
    )
    private newquizeapp.data.Attempt attempt;

    public UserWithAttempts(newquizeapp.data.User user, newquizeapp.data.Attempt attempt) {
        this.user = user;
        this.attempt = attempt;
    }

    protected UserWithAttempts(Parcel in) {
        user = in.readParcelable(newquizeapp.data.User.class.getClassLoader());
        attempt = in.readParcelable(newquizeapp.data.Attempt.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(user, flags);
        dest.writeParcelable(attempt, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserWithAttempts> CREATOR = new Creator<UserWithAttempts>() {
        @Override
        public UserWithAttempts createFromParcel(Parcel in) {
            return new UserWithAttempts(in);
        }

        @Override
        public UserWithAttempts[] newArray(int size) {
            return new UserWithAttempts[size];
        }
    };

    public User getUser() {
        return user;
    }

    public Attempt getAttempt() {
        return attempt;
    }
}
