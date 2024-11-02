class HashSetImp<T>{
    HashSet<T> set = new HashSet<T>();
    public void Add(T val ){
        set.Add(val);
        Console.WriteLine("Added to set : " + val);
    }
    public void Remove(T val){
        set.Remove(val);
        Console.WriteLine("Removed from set : " + val);
    }
    public void Display(){
        if(set.Count > 0){
            foreach(T val in set){
                Console.WriteLine(val);
            }
        }else{
            Console.WriteLine("Set is empty");
        }
    }
}