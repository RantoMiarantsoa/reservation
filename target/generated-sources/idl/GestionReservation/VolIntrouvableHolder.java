package GestionReservation;

/**
 * Generated from IDL exception "VolIntrouvable".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public final class VolIntrouvableHolder
	implements org.omg.CORBA.portable.Streamable
{
	public GestionReservation.VolIntrouvable value;

	public VolIntrouvableHolder ()
	{
	}
	public VolIntrouvableHolder(final GestionReservation.VolIntrouvable initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return GestionReservation.VolIntrouvableHelper.type ();
	}
	public void _read(final org.omg.CORBA.portable.InputStream _in)
	{
		value = GestionReservation.VolIntrouvableHelper.read(_in);
	}
	public void _write(final org.omg.CORBA.portable.OutputStream _out)
	{
		GestionReservation.VolIntrouvableHelper.write(_out, value);
	}
}
