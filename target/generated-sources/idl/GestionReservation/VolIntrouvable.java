package GestionReservation;

/**
 * Generated from IDL exception "VolIntrouvable".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public final class VolIntrouvable
	extends org.omg.CORBA.UserException
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public VolIntrouvable()
	{
		super(GestionReservation.VolIntrouvableHelper.id());
	}

	public java.lang.String volId = "";
	public VolIntrouvable(java.lang.String _reason,java.lang.String volId)
	{
		super(_reason);
		this.volId = volId;
	}
	public VolIntrouvable(java.lang.String volId)
	{
		super(GestionReservation.VolIntrouvableHelper.id());
		this.volId = volId;
	}
}
