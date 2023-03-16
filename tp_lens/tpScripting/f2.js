function add(a,b){
  return a+b;
}

var z=add(x,y); //z will be found in bindings after script execution

print("internal javascript print of z=" + z);

2*z //last eval returned value
