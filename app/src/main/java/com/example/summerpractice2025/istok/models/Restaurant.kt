import android.os.Parcel
import android.os.Parcelable

data class Restaurant(
    val name: String,
    val imageResId: Int,
    val description: String,
    val price: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(imageResId)
        parcel.writeString(description)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Restaurant> {
        override fun createFromParcel(parcel: Parcel): Restaurant = Restaurant(parcel)
        override fun newArray(size: Int): Array<Restaurant?> = arrayOfNulls(size)
    }
}