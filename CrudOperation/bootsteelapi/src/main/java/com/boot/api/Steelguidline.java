package com.boot.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Steelguidline
{
@Autowired
	private SteelRepository steelrepository;
	//private static List<Steel> list=new ArrayList<>();
  //  static{
//list.add(new Steel(9876,"maharashtra","india"));
//list.add(new Steel(6438,"london","america"));
//list.add(new Steel(1923,"wuhan","china"));    

//}
public List<Steel> getAllsteels()
{
List<Steel> list=(List<Steel>)this.steelrepository.findAll();
	return list;
}
public Steel getSteelById(int id)
{
Steel steel=null;
try
{
//steel = list.stream().filter(e -> e.getId()== id).findFirst().get();
steel=this.steelrepository.findById(id);
}
catch(Exception e)
{
e.printStackTrace();
}
	return steel;
}
public Steel addSteel(Steel b)
{
Steel result=steelrepository.save(b);
return result;
}
public void deleteSteel(int sid)
{
//list.stream().filter(steel-> steel.getId()!=sid).collect(Collectors.toList());
steelrepository.deleteById(sid);
}
public void UpdateSteel(Steel steel,int steelid)
{
//list =list.stream().map(b->{
//if(b.getId()==steelid)
//{
	//b.setLocation(b.getLocation());
    //b.setDestination(b.getDestination());
//}
	//return b;
//}).collect(Collectors.toList());
steel.setId(steelid);
	steelrepository.save(steel);
}
}