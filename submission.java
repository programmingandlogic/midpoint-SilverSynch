import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel 
{
	
	// we create our interger to record with.
	int worldLength;
	public void run()
	{
		
		/*
		 * we first collect the length of the world, then put either a beeper in the center (odd length)
		 * or two in corners next to the center (even length).
		 */
		collectData();
		finish();
	}
	
	private void collectData()
	{
		
		// as long as we can move foreward, the world continues.
		while(frontIsClear())
		{
			worldLength++;
			move();
		}
		turnAround();
	}
	
	private void finish()
	{
		
		// we check if the length is a even number (by judging it with modulo)
		if ((worldLength % 2 >= 1))
		{
			
			// we divide our number so we only go halfway
			worldLength = worldLength / 2;
			
			// we don't need to create a new int to calculate this.
			for(; worldLength > 0; worldLength--)
			{
				move();
			}
			
			/*
			 * this leaves us on the corner to the right of the center (which is unreachable on a strict
			 * grid), so we put one, then move and place the left one.
			 */
			putBeeper();
			move();
			putBeeper();
		}
		
		// if our length is odd (or something went wrong with our calculations)
		else
		{
			
			/*
			 * as before, we halve our number. but since this is an int, it is automatically rounded,
			 * so we don't have to deal with .5s. this might be bad implementation, but we lack other
			 * enviroments for this to matter in.
			 */
			worldLength = worldLength / 2;
			for(; worldLength > 0; worldLength--)
			{
				move();
			}
			
			/*
			 * since this leaves us in the middle (don't think about it too hard, I don't know how
			 * that happens with flooring either), we only need to make one beeper.
			 */
			putBeeper();
		}
	}
}
