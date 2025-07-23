import android.os.Parcel
import android.os.Parcelable

data class Teacher(
    val name: String,
    val imageResId: Int,
    val description: String,
    val exam: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(imageResId)
        parcel.writeString(description)
        parcel.writeString(exam)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Teacher> {
        override fun createFromParcel(parcel: Parcel): Teacher = Teacher(parcel)
        override fun newArray(size: Int): Array<Teacher?> = arrayOfNulls(size)
    }
}