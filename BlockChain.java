import Block

public class BlockChain
{
	ArrayList<Block> BC;
	
	public BlockChain()
	{
		BC= new ArrayList<Block>();
		Block GENESISblock= new Block();
		addBlock(GENESISblock);
	}
	
	public void addBlock(Block prevBolake, data)
	{
		int index= prevBolake.index+1;
		String prevHash= prevBolake.hash;
		double timestamp=time();
		String hash= 
		BC.add(bolake);
	}
	
}
