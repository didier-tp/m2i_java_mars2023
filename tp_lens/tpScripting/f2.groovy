def add(a,b){
  return a+b
}

z=add(x,y) //z will be found in bindings after script execution

println("internal groovy println of z=" + z);

return 2*z;
