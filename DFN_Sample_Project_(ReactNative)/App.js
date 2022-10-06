/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import AdbrixRm from 'react-native-adbrix-remaster';
import type {Node} from 'react';
import {
  Alert,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  Button,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

/* $FlowFixMe[missing-local-annot] The type annotation(s) required by Flow's
 * LTI update could not be added via codemod */
const Section = ({children, title}): Node => {
  const isDarkMode = useColorScheme() === 'dark';
  return (
    <View style={styles.sectionContainer}>
      <Text
        style={[
          styles.sectionTitle,
          {
            color: isDarkMode ? Colors.white : Colors.black,
          },
        ]}>
        {title}
      </Text>
      <Text
        style={[
          styles.sectionDescription,
          {
            color: isDarkMode ? Colors.light : Colors.dark,
          },
        ]}>
        {children}
      </Text>
    </View>
  );
};

const App: () => Node = () => {
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  AdbrixRm.initRNPlugin();

  return (

        <View
          style={{
            backgroundColor: isDarkMode ? Colors.black : Colors.white, flex : 1, marginHorizontal : 16,
          }}>
            <Text style = {styles.title}> DFINERY Test App for React Native</Text>
            <Button title="Sample Custom Event 1" onPresse = {() => AdbrixRm.event("your_sample_event_1")}/>
            <Button title="Sample Custom Event 2" onPresse = {() => AdbrixRm.event("your_sample_event_2")}/>


        </View>

  );
};

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
  title:{
    textAlign: 'center',
    paddingVertical : 30,
    fontSize : 35,
  },
  button : {
    alignItems : 'center',
    backgroundColor : '#DDDDDD',
    padding : 10
  }
});

export default App;
