package com.start.diary.ForTest;

import lombok.*;

import java.util.Objects;

@Data
@RequiredArgsConstructor()
public class Just {
     private int id;
     protected String ke;
    private String name;
    private String country;

    @Override
    public boolean equals(Object o) {
        System.out.println("Eq");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        System.out.println("Eq2");
        Just just = (Just) o;
        return id == just.id &&
                Objects.equals(ke, just.ke);
    }

    @Override
    public int hashCode() {
        System.out.println("Hash");
        return Objects.hash(id, ke);
    }

    public void justMethod(){
        System.out.println("method");
    }
}
