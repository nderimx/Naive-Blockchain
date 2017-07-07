public class Main
{
	public static void main(String[] args)
	{
		BlockChain firstBC= new BlockChain();
		firstBC.generateBlock("tadaaa, it's a two block chain now");
		System.out.println(firstBC.toString());
	}
}
