/*********************************************
 * OPL 12.6.0.0 Model
 * Author: Victor
 * Creation Date: 31/05/2016 at 21:07:34
 *********************************************/

 //parameters
  int n=...; //numbers of cargo
  int m=...; //number of compartment
  
  range cargos = 1..n;
  range compar = 1..m;
  
  float profit[cargos] = ...;
  float weight[cargos] = ...;
  float volume[cargos] = ...;
  
  float weight_cap[compar] = ...;
  float space_cap[compar] = ...;
  
  //variables
  dvar float+ x[cargos][compar];
  dvar float+ y;
	
  maximize sum(i in cargos, j in compar) profit[i]*x[i][j];
  
  subject to {
  	forall(i in cargos)  
  		available_weight:
  		sum(j in compar) x[i][j] <= weight[i];
  		
  	forall(j in compar)
  	  weight_capacity:
  	  sum(i in cargos) x[i][j] <= weight_cap[j];
  	  
   forall(j in compar)
     space_capacity:
     sum(i in cargos) volume[i] * x[i][j] <= space_cap[j];
     
   forall(j in compar)
     balanced_plane:
     sum(i in cargos) x[i][j]/weight_cap[j] == y;
     
  }
	