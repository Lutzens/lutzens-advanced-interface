/**
 * Project     : LutzensAdvancedInterface
 * Klasse      : InterfaceWithAttributes
 * Version     : 1
 * Date        : 26.10.2014 07:21:34
 * Author      : Lutz Hoffarth
 * Copyright(c): Lutz Hoffarth 2014
 */

package de.lutzens.tool.common.advanced.interfaces;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Dieses Interface kann statische und nicht statische Attribute zu den implementierten Objekten, Klassen oder Interfaces beinhalten.
 * <p>
 * Attribute, von Objekten die nicht mehr referenziert werden, werden automatisch entfernt.
 * <p>
 * <a href="https://github.com/Lutzens/lutzens-advanced-interface">https://github.com/Lutzens/lutzens-advanced-interface</a>
 * <p>
 * @author <a href="mailto:office@lutzens.de">Lutz Hoffarth</a>
 * @since 26.10.2014 07:21:34 Lutz Hoffarth | Realisierung
 * @since 03.12.2014 16:54:45 Lutz Hoffarth | Erweiterung um statische Objekt-Attribute.
 * @since 18.06.2016 10:23:11 Lutz Hoffarth | Erweiterung um statische Schnittstellen-Attribute.
 * @since 13.07.2017 10:23:25 Lutz Hoffarth | Auslagerung der Funktionsattribute in den Kontrolleur {@link InterfaceWithAttributeController}.
 * @since 13.07.2017 10:23:25 Lutz Hoffarth | Auslagerung der Funktionen aller Methoden in den Kontrolleur {@link InterfaceWithAttributeController}.
 */
public interface InterfaceWithAttributes {
  
  //  /* -- Konstante --------------------------------------------------------------------------------- */
  /* -- Default-Method ---------------------------------------------------------------------------- */
  
  /**
   * In der {@link WeakHashMap} wird dem Object zugehörig ein {@link AttributesOfInterface} abgelegt.<p>
   * Erst durch die Initialisierung im Object wird die Funktionalität aktiviert. 
   * @since 26.10.2014 07:44:34 Lutz Hoffarth | Realisierung
   */
  default void initInterfaceWithAttribute() {
    InterfaceWithAttributeController.init(this);
  }
  
  /* ---- Eigenschaften des Objektes --------------------------------------- */
  
  /**
   * Liefert die zum Objekt gehörigen {@link AttributesOfInterface}s.<p>
   * @return {@link AttributesOfInterface}
   * @since 26.10.2014 07:47:25 Lutz Hoffarth | Realisierung
   * @since 13.07.2017 10:17:35 Lutz Hoffarth | Return in {@link HashMap} geändert.
   */
  default HashMap<String, Object> getObjectAttributes() {
    return InterfaceWithAttributeController.getObjectAttributes(this).get();
  }
  
  /**
   * @return Identifizierer des Objekts.
   * @since 13.07.2017 09:36:23 Lutz Hoffarth | Realisierung
   */
  default long getObjectId() {
    return InterfaceWithAttributeController.getObjectAttributes(this).getId();
  }
  
  /**
   * Liefert das Attribute des Objekts mit dem übergebenen Namen.
   * @param key Attributname
   * @return Object
   * @since 22.12.2014 18:59:42 Lutz Hoffarth | Realisierung
   */
  default Object getObjectAttribute(String key) {
    return InterfaceWithAttributeController.getObjectAttribute(this, key);
  }
  
  /**
   * Setzt den Wert im Objekt-Attribute mit dem übergebenen Namen.
   * @param key Attributname
   * @param value Wert
   * @since 22.12.2014 19:04:43 Lutz Hoffarth | Realisierung
   */
  default void setObjectAttribute(String key, Object value) {
    InterfaceWithAttributeController.setObjectAttribute(this, key, value);
  }
  
  /**
   * übernimmt alle Attribute der übergebenen Schnittstelle zu der bestehenden hinzu.<p>
   * @param as {@link InterfaceWithAttributes}
   * @since 18.11.2015 18:17:50 Lutz Hoffarth | Realisierung
   */
  default void addObjectAttributes(InterfaceWithAttributes as) {
    InterfaceWithAttributeController.addObjectAttributes(this, as);
  }
  
  /* ---- Statische Eigenschaften der Klasse ------------------------------- */
  
  /**
   * Liefert die zur Klasse gehörigen statischen Eigenschaften des {@link AttributesOfInterface}s.
   * <p>
   * Statische Eigenschaften des Interfaces betrifft die aktuelle Klassen, die das Interface implementieren.
   * <p>
   * @return {@link AttributesOfInterface}
   * @since 03.12.2014 16:46:47 Lutz Hoffarth | Realisierung
   * @since 13.07.2017 10:17:12 Lutz Hoffarth | Return in {@link HashMap} geändert.
   */
  default HashMap<String, Object> getClassAttributes() {
    return InterfaceWithAttributeController.getClassAttributes(this).get();
  }
  
  /**
   * Liefert das statische Attribut der Klasse im Interface mit dem übergebenen Namen.
   * <p>
   * Statische Eigenschaften des Interfaces betrifft die aktuelle Klassen, die das Interface implementieren.
   * <p>
   * @param key Attributname
   * @return Object
   * @since 22.12.2014 19:05:32 Lutz Hoffarth | Realisierung
   */
  default Object getClassAttribute(String key) {
    return InterfaceWithAttributeController.getClassAttribute(this, key);
  }
  
  /**
   * Setzt das statische Attribut der Klasse im Interface.
   * <p>
   * Statische Eigenschaften des Interfaces betrifft die aktuelle Klassen, die das Interface implementieren.
   * <p>
   * @param key Attributname
   * @param value Wert
   * @since 22.12.2014 19:06:07 Lutz Hoffarth | Realisierung
   */
  default void setClassAttribute(String key, Object value) {
    InterfaceWithAttributeController.setClassAttribute(this, key, value);
  }
  
  /* ---- Statische Eigenschaften des Interfaces --------------------------- */
  
  /**
   * Liefert das statische Attribut des Interfaces mit dem übergebenem Namen.
   * <p>
   * Statische Eigenschaften des Interfaces betrifft alle Klassen, die das Interface implementieren.
   * <p>
   * @return Object
   * @since 18.06.2016 10:24:26 Lutz Hoffarth | Realisierung
   */
  default HashMap<String, Object> getInterfaceAttributes() {
    return InterfaceWithAttributeController.getInterfaceAttributes().get();
  }
  
  /**
   * Liefert das statische Attribut des Interfaces mit dem übergebenem Namen.
   * <p>
   * Statische Eigenschaften des Interfaces betrifft alle Klassen, die das Interface implementieren.
   * <p>
   * @param key Attributname
   * @return Object
   * @since 18.06.2016 10:24:26 Lutz Hoffarth | Realisierung
   */
  default Object getInterfaceAttribute(String key) {
    return InterfaceWithAttributeController.getInterfaceAttribute(key);
  }
  
  /**
   * Setzt das statische Attribut des Interfaces.
   * <p>
   * Statische Eigenschaften des Interfaces betrifft alle Klassen, die das Interface implementieren.
   * <p>
   * @param key Attributname
   * @param value Wert
   * @since 18.06.2016 10:24:26 Lutz Hoffarth | Realisierung
   */
  default void setInterfaceAttribute(String key, Object value) {
    InterfaceWithAttributeController.setInterfaceAttribute(key, value);
  }
  
}
