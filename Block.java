import java.security.MessageDigest;
public class Block
{
	private int index;
	private String hash;
	private String prevHash;
	private double timestamp;
	private String data;
	private static int GENESISindex=0;
	private static String GENESISprevHash="0";
	private static double GENESIStimestamp=1499221909.6811388;
	private static String GENESISdata="first block";
	
	public Block(int index, String prevHash, double timestamp, String data)
	{
		this.index=index;
		this.prevHash=prevHash;
		this.timestamp=timestamp;
		this.data=data;
		this.hash=this.scramble();
	}
	
	public String scramble()
	{
		String text = this.toString();
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(text.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++)
			{
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		}
		catch(Exception ex){throw new RuntimeException(ex);}
	}
	
	public boolean hasValidIndex(Block prevBlock)
	{
		return (prevBlock.index==index+1);
	}
	
	public boolean hasValidPrevHash(Block prevBlock)
	{
		return (prevBlock.hash==prevHash);
	}
	
	public boolean hasValidHash()
	{
		return (hash==this.scramble());
	}
	
	public static Block genesisBlock()
	{
		return new Block(GENESISindex, GENESISprevHash, GENESIStimestamp, GENESISdata);
	}
	
	public String toString()
	{
		return ""+index+prevHash+timestamp+data;
	}
	
	public int getIndex(){return index;}
	public String getHash(){return hash;}
	public String getPrevHash(){return prevHash;}
	public double getTimestamp(){return timestamp;}
	public String getData(){return data;}
}
