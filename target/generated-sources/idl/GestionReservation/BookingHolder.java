package GestionReservation;

/**
 * Generated from IDL interface "Booking".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public final class BookingHolder	implements org.omg.CORBA.portable.Streamable{
	 public Booking value;
	public BookingHolder()
	{
	}
	public BookingHolder (final Booking initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return BookingHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = BookingHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		BookingHelper.write (_out,value);
	}
}
