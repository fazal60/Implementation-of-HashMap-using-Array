
public class HashMap {
	int SIZE=128;
	Entry table[]=new Entry[SIZE];
	
	public HashMap()
	{
		for(int i=0;i<SIZE;i++)
		{
			table[i]=null;
		}
	}
	
	public void put(int key, int val)
	{
		int hash=key%SIZE;
		if(table[hash]==null)
		{
			Entry obj=new Entry();
			obj.setKey(key);
			obj.setValue(val);
			obj.setNext(null);
			table[hash]=obj;
		}
		else if(table[hash].getKey()==key)
		{
			table[hash].setValue(val);
		}
		else
		{
			Entry ent=table[hash];
			while(ent!=null)
			{
				ent=ent.getNext();
			}
			Entry newEnt=new Entry();
			newEnt.setKey(key);
			newEnt.setValue(val);
			newEnt.setNext(null);
			ent.setNext(newEnt);
		}
	}
	
	public int get(int key)
	{
		int hash=key%SIZE;
		if(table[hash]==null)
		{
			return 0;
		}
		else if(table[hash].getKey()==key)
		{
			return table[hash].getValue();
		}
		else
		{
			Entry ent=table[hash];
			while(ent!=null)
			{
				if(ent.getKey()==key)
					return ent.getValue();
				ent=ent.getNext();
			}
		}
		return 0;
	}
}
