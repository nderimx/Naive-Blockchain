public class Block
{
	private int index;
	private String hash;
	private String prevHash;
	private double timestamp;
	private String data;
	public int GENESISindex=0;
	public String GENESISprevHash="0";
	public double GENESIStimestamp=1499221909.6811388;
	public String GENESISdata="first block";
	
	public Block(int index, String prevHash, double timestamp, String data)
	{
		this.index=index;
		this.preshHash=prevHash;
		this.timestamp=timestamp;
		this.data=data;
		this.hash=this.scramble();
	}
	
	public String scramble()
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String text = this.toString();

		md.update(text.getBytes("UTF-8"));
		byte[] digest = md.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < digest.length; i++)
		{
			String hex = Integer.toHexString(0xff & digest[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	public boolean hasValidIndex(Block prevBlock)
	{
		return (prevBlock.index==index+1)
	}
	
	public boolean hasValidPrevHash(Block prevBlock)
	{
		return (prevBlock.hash==prevHash)
	}
	
	public boolean hasValidHash()
	{
		return (hash==this.scramble())
	}
	
	public Block genesisBlock()
	{
		return Block(GENESISindex, GENESISprevHash, GENESIStimestamp, GENESISdata);
	}
	
	public String toString()
	{
		return ""+index+previousHash+timestamp+data;
	}
	
}
