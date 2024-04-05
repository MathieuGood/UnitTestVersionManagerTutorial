package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionManagerTest {

    private static VersionManager instance = null;

    @BeforeAll
    static void beforeAll() {
        instance = new VersionManager();
    }

    @BeforeEach
    void setUp() {
        instance.setVersion(1);
    }

    @Test
    @DisplayName("Test initialisation à 1")
    void testInit() {
        assertEquals(1, instance.getVersion());
    }

    @Test
    @DisplayName("Test toString")
    void testToString() {
        assertEquals("Version: 1", instance.toString());
    }


    @Test
    @DisplayName("Test updateVersion(ETypeUpdate MAJEUR)")
    void testUpdateVersionMAJEUR() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        assertEquals(101, instance.getVersion());
    }

    @Test
    @DisplayName("Test updateVersion(ETypeUpdate MINEUR)")
    void testUpdateVersionMINEUR() {
        instance.updateVersion(ETypeUpdate.MINEUR);
        assertEquals(11, instance.getVersion());
    }

    @Test
    @DisplayName("Test updateVersion(ETypeUpdate PATCH)")
    void testUpdateVersionPATCH() {
        instance.updateVersion(ETypeUpdate.PATCH);
        assertEquals(2, instance.getVersion());
    }

    @Test
    @DisplayName("Test updateVersion(DEFAULT)")
    void testUpdateVersionDefault() {
        instance.updateVersion(ETypeUpdate.OTHER);
        assertEquals(1, instance.getVersion());
    }


    @Test
    @DisplayName("Test setVersion(582)")
    void testSetVersionPositiveInt() {
        instance.setVersion(582);
        assertEquals(582, instance.getVersion());
    }


    @Test
    @DisplayName("Test setVersion(-631)")
    void testSetVersionNegativeInt() {
        instance.setVersion(-631);
        assertEquals(-631, instance.getVersion());
    }

    @Test
    @DisplayName("Test setVersion(0)")
    void testSetVersionZero() {
        instance.setVersion(0);
        assertEquals(0, instance.getVersion());
    }

    @Test
    @DisplayName("Test updateVersion() MAJEUR + MINEUR + PATCH")
    void testUpdateVersionMajMinPatch() {
        instance.updateVersion(ETypeUpdate.MAJEUR);
        instance.updateVersion(ETypeUpdate.MINEUR);
        instance.updateVersion(ETypeUpdate.PATCH);
        assertEquals(112, instance.getVersion());
    }

    @Test
    @DisplayName("Test updateVersion() PATCH + MINEUR + MAJEUR")
    void testUpdateVersionPatchMinMaj() {
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.MINEUR);
        instance.updateVersion(ETypeUpdate.MAJEUR);
        assertEquals(112, instance.getVersion());
    }


    @Test
    @DisplayName("Test updateVersion() PATCH*5")
    void testUpdatePatchFiveTimes() {
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.PATCH);
        instance.updateVersion(ETypeUpdate.PATCH);
        assertEquals(6, instance.getVersion());
    }



}

