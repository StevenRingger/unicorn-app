package ch.unicorn.config.mapping;

/**
 * This interface ensures that a MapperPreset can be provided by the
 * implementing class. All MapperPreset-Enums must implement this interface
 *
 */
public interface MapperPresetProvider {
	/**
	 * This method returns the {@link MapperPreset} provided by this
	 * {@link MapperPresetProvider}
	 *
	 * @return MapperPreset The {@link MapperPreset} provided by this
	 *         {@link MapperPresetProvider}
	 */
	MapperPreset getPreset();
}