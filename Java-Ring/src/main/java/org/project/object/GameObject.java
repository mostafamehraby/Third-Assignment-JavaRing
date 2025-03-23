package org.project.object;

import org.project.entity.Entity;

public interface GameObject {

    void use(Entity target);

    String getName(); // دریافت نام شیء

    String getType(); // دریافت نوع شیء

    boolean isUsable(); // بررسی اینکه آیا شیء قابل استفاده است

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
