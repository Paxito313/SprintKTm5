import android.os.Parcel
import android.os.Parcelable

interface Producto {
    val nombre: String
    val precio: Double
    val descripcion: String
}

data class Zapato(
    override val nombre: String,
    override val precio: Double,
    override val descripcion: String,
    val imagenUrl: String
) : Producto, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    // Escribir los datos del objeto Zapato al Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeDouble(precio)
        parcel.writeString(descripcion)
        parcel.writeString(imagenUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Zapato> {
        override fun createFromParcel(parcel: Parcel): Zapato {
            return Zapato(parcel)
        }

        override fun newArray(size: Int): Array<Zapato?> {
            return arrayOfNulls(size)
        }
    }
}
