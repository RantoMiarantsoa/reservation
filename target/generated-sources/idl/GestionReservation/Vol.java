package GestionReservation;

/**
 * Generated from IDL struct "Vol".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 24 sept. 2026, 11:11:14
 */

public final class Vol
	implements org.omg.CORBA.portable.IDLEntity
{
	/** Serial version UID. */
	private static final long serialVersionUID = 1L;
	public Vol(){}
	public java.lang.String idVol = "";
	public java.lang.String companie = "";
	public java.lang.String lieuDepart = "";
	public java.lang.String lieuArrivee = "";
	public java.lang.String dateDepart = "";
	public java.lang.String dateArrivee = "";
	public double prixBase;
	public Vol(java.lang.String idVol, java.lang.String companie, java.lang.String lieuDepart, java.lang.String lieuArrivee, java.lang.String dateDepart, java.lang.String dateArrivee, double prixBase)
	{
		this.idVol = idVol;
		this.companie = companie;
		this.lieuDepart = lieuDepart;
		this.lieuArrivee = lieuArrivee;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.prixBase = prixBase;
	}
}
