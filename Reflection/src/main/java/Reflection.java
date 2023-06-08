import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reflection {
    public static Animal mapToProductDto(Pet pet){
        Animal animal = new Animal();
        try{
            Class clazzPet = pet.getClass();
            Class clazzAnimal = animal.getClass();

            Field petFieldName = clazzPet.getDeclaredField("name");
            petFieldName.setAccessible(true);
            String petValueName = (String) petFieldName.get(pet);
            Field animalFieldName = clazzAnimal.getDeclaredField("title");
            animalFieldName.setAccessible(true);
            animalFieldName.set(animal, petValueName);


            Field petFieldStatus = clazzPet.getDeclaredField("status");
            petFieldStatus.setAccessible(true);
            Pet.Status petValueStatus = (Pet.Status) petFieldStatus.get(pet);

            if (petValueStatus == Pet.Status.AVAILABLE){
                Field animalFieldIsAvailable = clazzAnimal.getDeclaredField("isAvailable");
                animalFieldIsAvailable.setAccessible(true);
                animalFieldIsAvailable.set(animal, true);
                Field animalFieldIsSold = clazzAnimal.getDeclaredField("isSold");
                animalFieldIsSold.setAccessible(true);
                animalFieldIsSold.set(animal, false);
            }else{
                Field animalFieldIsAvailable = clazzAnimal.getDeclaredField("isAvailable");
                animalFieldIsAvailable.setAccessible(true);
                animalFieldIsAvailable.set(animal, false);
                Field animalFieldIsSold = clazzAnimal.getDeclaredField("isSold");
                animalFieldIsSold.setAccessible(true);
                animalFieldIsSold.set(animal, true);
            }

            Map <String, String> photosMap = new HashMap<>();
            Field petFieldPhotoList = clazzPet.getDeclaredField("photosList");
            petFieldPhotoList.setAccessible(true);
            String key, data;
            List petValuePhotoList = (List) petFieldPhotoList.get(pet);
            for(int i = 0; i < petValuePhotoList.size(); i++){
                Class clazz = petValuePhotoList.get(i).getClass();

                Method method = clazz.getMethod("getName");
                key = (String) method.invoke(petValuePhotoList.get(i));
                method = clazz.getMethod("getURL");
                data = (String) method.invoke(petValuePhotoList.get(i));
                photosMap.put(key, data);
            }
            Field animalFieldPhotoMap = clazzAnimal.getDeclaredField("photosMap");
            animalFieldPhotoMap.setAccessible(true);
            animalFieldPhotoMap.set(animal, photosMap);

        }catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException |InvocationTargetException e ) {
            e.printStackTrace();
        }
        return animal;
    }

    public static void main(String[] args){
        Pet newPet = new Pet("Barsick", Pet.Status.AVAILABLE, List.of(new Pet.Photo("Barsick with flowers", "www.google.com"),
                                                                new Pet.Photo("Barsick on hands", "www.google.com")));
        Animal animalNewPet = mapToProductDto(newPet);
        System.out.println(animalNewPet);



    }
}
