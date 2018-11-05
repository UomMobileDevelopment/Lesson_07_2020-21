# Lesson_06_2018-19
Use of an external Library, the Youtube Player. 
Use of Intents

### The project of this lesson has 2 main prerequisites:
1. Get Youtube player android api jar from [here](https://developers.google.com/youtube/android/player/).  (Section download)

2. Create Google API project and get youtube api key from [here](https://console.developers.google.com/). (Notice: You need a gmail account for this)


### API classes and concepts to explore:

1. [YoutubeStandalonePlayer](https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubeStandalonePlayer)
2. [Intents and Filters](https://developer.android.com/guide/components/intents-filters)


### Ασφαλής χειρισμός Youtube API KEY

Όπως είπαμε και σήμερα στο μάθημα, ΔΕΝ πρέπει να δημοσιεύσετε το API κλειδί στον κώδικα της εργασίας σας που θα ανεβεί 
δημόσια στο GitHub.

Θα πρέπει να βάλετε το API ΚΕΥ σε ένα αρχείο στον φάκελο /user/.gradle του υπολογιστή σας και να το διαβάζετε απο εκεί.

```
1. Προσθέστε μια γραμμή στο αρχείο ~/.gradle/gradle.properties  (αν δεν υπάρχει ήδη, δημιουργήστε το), 
η γραμμή θα πρέπει να έχει τη μορφή:
MySuperKey=”YOUR_API_KEY”

2. Στον κωδικά σας, αλλάξτε το αρχείο app/build.gradle 

android {

....
....
...
    buildTypes.each {
        it.buildConfigField 'String', 'SUPER_KEY_FOR_USE_IN_CODE', MySuperKey
    }
}
```
