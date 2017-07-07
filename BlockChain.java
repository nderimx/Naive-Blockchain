import java.util.ArrayList;

public class BlockChain
{
	ArrayList<Block> BC;
	
	public BlockChain()
	{
		BC= new ArrayList<Block>();
		BC.add(Block.genesisBlock());
	}
	
	public void generateBlock(String data)
	{
		double timestamp= System.currentTimeMillis();
		int index= this.latestBlock().getIndex()+1;
		String prevHash= this.latestBlock().getHash();
		Block bolake= new Block(index, prevHash, timestamp, data);
		BC.add(bolake);
	}
	
	public void receiveBlock(Block bolake)
	{
		if (!bolake.hasValidIndex(latestBlock()))
			return;
		if (!bolake.hasValidPrevHash(latestBlock()))
			return;
		if (!bolake.hasValidHash())
			return;
		BC.add(bolake);
	}
	
	public Block latestBlock()
	{
		return BC.get(BC.size()-1);
	}
	
	public String toString()
	{
		String text="";
		for (int i=0; i<BC.size(); i++)
		{
			text+="{(index="+BC.get(i).getIndex()+
			"),(data="+BC.get(i).getData()+
			"),(timestamp="+BC.get(i).getTimestamp()+
			"),(hash="+BC.get(i).getHash()+
			"),(previous_hash="+BC.get(i).getPrevHash()+
			")}";
		}
		return text;
	}
}
