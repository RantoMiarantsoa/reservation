package GestionReservation;

/**
 * Generated from IDL struct "Vol".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public final class VolHolder
	implements org.omg.CORBA.portable.Streamable
{
	public GestionReservation.Vol value;

	public VolHolder ()
	{
	}
	public VolHolder(final GestionReservation.Vol initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return GestionReservation.VolHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = GestionReservation.VolHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		GestionReservation.VolHelper.write(_out, value);
	}
}
