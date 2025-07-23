import android.os.Parcel
import android.os.Parcelable

data class EducationalResource(
    val title: String,
    val imageResId: Int,
    val description: String,
    val link: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(imageResId)
        parcel.writeString(description)
        parcel.writeString(link)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<EducationalResource> {
        override fun createFromParcel(parcel: Parcel): EducationalResource = EducationalResource(parcel)
        override fun newArray(size: Int): Array<EducationalResource?> = arrayOfNulls(size)
    }
}