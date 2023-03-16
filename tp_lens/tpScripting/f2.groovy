def add(a,b){
  return a+b
}

z=add(x,y) //z will be found in bindings after script execution

println("internal groovy println of z=" + z);

println("internal groovy println of calcul.x=" + calcul.x);
calcul.calculerRacineCarree();
println("internal groovy println of calcul.res=" + calcul.res);

return 2*z;
